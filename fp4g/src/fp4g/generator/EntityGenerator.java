package fp4g.generator;

import static fp4g.Log.Show;

import java.util.Map.Entry;

import com.apollo.Entity;
import com.apollo.EntityBuilder;
import com.apollo.World;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.JType;
import com.sun.codemodel.JVar;

import fp4g.Log.ErrType;
import fp4g.Log.WarnType;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.Function;
import fp4g.data.IScope;
import fp4g.data.FactoryType;


public class EntityGenerator {
	private static JPackage entityPack = null;
	private final JCodeModel jcm;
	private final String defineName;
	private final IScope defineScope;

	public EntityGenerator(Define define) {
		jcm = Utils.getJCM();
		defineName = define.getName();
		defineScope = define.getScope();

		if (entityPack == null) {
			entityPack = jcm._package(String.format("%s.%s", Utils
					.getGamePackage().name(), "entity"));
		}
	}

	public JDefinedClass generate() throws JClassAlreadyExistsException,
			ClassNotFoundException {
		// crear una nueva clase...
		JDefinedClass entityFactory = entityPack._class(String.format(
				"%sFactory", defineName));
		entityFactory._implements(EntityBuilder.class);
		// JExpression nameExpr = Utils.getExpr(defineName);

		// {
		// JMethod constructor =
		entityFactory.constructor(JMod.PUBLIC);
		// }
		{
			JMethod method = entityFactory.method(JMod.PUBLIC, String.class,
					"getEntityBuildName");
			method.annotate(Override.class);
			method.body()._return(Utils.getExpr(defineName));

		}
		// createInstance
		JMethod createInstance = entityFactory.method(JMod.PUBLIC,
				Entity.class, "buildEntity"); // public Entity build(...
		JVar worldParam = createInstance.param(World.class, "world"); // World
																		// world
		createInstance.annotate(Override.class); // @Override
		JBlock createBlock = createInstance.body();
		JVar entityVar = null;

		{
			JType entityClass = jcm._ref(Entity.class);
			JInvocation inv = JExpr._new(entityClass).arg(worldParam);
			entityVar = createBlock.decl(entityClass, "entity", inv);
		}

		for (Entry<String, Object> entry : defineScope.toArray()) {
			// String key = entry.getKey();
			Object value = entry.getValue();

			JExpression expr = Utils.getExpr(value);
			if (expr != null) {
				// el objeto field
				// block.add((JStatement) field.assign(expr));
				// TODO decidir que hacer con esto
			} else if (value instanceof IScope) {
				// assignScope(field,block,(Scope)value,action);
				// TODO decidir que hacer...
			} else if (value instanceof Function) {
				// Function f = (Function)value;
				// f.call(entityFactory, defineScope);
			} else if (value instanceof Add) {
				Add add = (Add) value;
				String addName = add.getName();
				IScope addScope = add.getScope();
				FactoryType addType = add.getType();
				Define addDefine = (Define) defineScope.get(addName);

				if (addDefine == null) {
					//warning: No se encontró una definición
					// previa al componente %s, se omitirá y se asumirá que ya
					// existe
					Show(WarnType.NotFoundDefine,add);
				}
				if (addDefine != null && addDefine.getType() != addType) {
					// No coinciden los tipos
					Show(ErrType.DontMatchTypes, add);
					continue;
				}				
				switch (addType) {
				case BEHAVIOR:
					if (addDefine != null) {
						addDefine.getScope().writeWithoutOverride(addScope);
					}

					// asumimos que existe
					JClass componentClass = jcm.ref(String.format("%s.%s",
							Utils.componentsPackageName, addName));

					JBlock block = createInstance.body();
					JInvocation newInv = JExpr._new(componentClass);
					newInv.arg(worldParam);
					if (addScope.size() > 0) {
						JClass dataClass = jcm.ref(String.format("%s.%s",
								componentClass.fullName(), "Def"));
						JExpression dataExpr = Utils.addDefClass(dataClass,
								addName, addScope, block);
						newInv.arg(dataExpr);
					}

					JVar componentVar = block.decl(componentClass,
							String.format("_%s", addName), newInv);
					block.add(entityVar.invoke("setComponent")
							.arg(componentVar));

					// JInvocation inv = JExpr._new(typeValue);
					// JBlock block = load.body();
					// // aqui hay que tomar el objeto scope y
					// // chantarselo...
					//
					// if(addScope.size()>0){
					// JExpression dataExpr = Utils.checkAndAdd(data, addName,
					// addScope, block);
					// inv.arg(dataExpr);
					// }
					//
					// // asignacion var = new Wea()...
					// block.assign(var, inv);
					// JInvocation addManagerInv =
					// world.invoke("setManager").arg(var);
					// block.add(addManagerInv);
					break;
				default:
					// no se esperaba esta wea...
					Show(WarnType.NotExpectedThis,add);
					break;

				}
			}
		}
		createBlock._return(entityVar);
		return entityFactory;

	}

}
