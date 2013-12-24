package fp4g.generator;

import fp4g.data.Define;
import fp4g.generator.gdx.models.JavaCodeModel;

public interface Depend {

	public abstract void perform(Define data, JavaCodeModel model);

}