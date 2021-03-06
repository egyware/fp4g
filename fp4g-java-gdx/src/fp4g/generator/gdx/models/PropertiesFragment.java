package fp4g.generator.gdx.models;

import fp4g.generator.Fragment;

public class PropertiesFragment implements Fragment 
{
	private String className;
	private String title;
	private int width;
	private int height;
	private boolean resizable;
	private boolean useGL30;
	
	/**
	 * @return the className
	 */
	public final String getClassName() {
		return className;
	}
	/**
	 * @param className the className to set
	 */
	public final void setClassName(String className) {
		this.className = className;
	}
	/**
	 * @return the title
	 */
	public final String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public final void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the width
	 */
	public final int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public final void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	public final int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public final void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return the resizable
	 */
	public final boolean isResizable() {
		return resizable;
	}
	/**
	 * @param resizable the resizable to set
	 */
	public final void setResizable(boolean resizable) {
		this.resizable = resizable;
	}
	/**
	 * @return the useGL30
	 */
	public final boolean isUseGL30() {
		return useGL30;
	}
	/**
	 * @param useGL30 the useGL30 to set
	 */
	public final void setUseGL30(boolean useGL30) {
		this.useGL30 = useGL30;
	}
	@Override
	public String getFragmentName() 
	{
		return PropertiesFragment.class.getSimpleName();
	}
	
	
	
//	game.class  = ${properties.class}
//	game.title  = ${properties.title}
//	game.width  = ${properties.width}
//	game.height = ${properties.height}
//	game.resizable = ${properties.resizable}
//	game.useGL20 = ${properties.useGL20}
}
