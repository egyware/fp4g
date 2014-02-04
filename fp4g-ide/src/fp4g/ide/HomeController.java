package fp4g.ide;


import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class HomeController 
{
	@FXML
	private WebView webView;
	
	public HomeController()
	{
		
	}
	
	public void initialize()
	{
		WebEngine engine = webView.getEngine();
		
		String url = Thread.currentThread().getContextClassLoader().getResource("fp4g/ide/web/index.html").toString();		
		engine.load(url);
		
	} 	
	 	
}
