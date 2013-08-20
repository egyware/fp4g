/**
 * 
 */
package fp4g.parser;

import fp4g.data.define.Game;


/**
 * Visita el arbol construido.
 * @author Edgardo
 *
 */
public class FP4GDataVisitor extends FP4GBaseVisitor<Void> {
	private Game game;
	public FP4GDataVisitor(Game game)
	{
		this.game = game;
	}
	
	@Override
	public Void visitGame(FP4GParser.GameContext ctx)
	{
		game.name = ctx.name;		
		System.out.println(game.name);
		
		return super.visitGame(ctx);		
	}
}
