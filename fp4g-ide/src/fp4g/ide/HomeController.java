package fp4g.ide;


import netscape.javascript.JSObject;

import org.w3c.dom.Document;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
		final WebEngine engine = webView.getEngine();		
		JSObject window = (JSObject)engine.executeScript("window");
		window.setMember("fp4g", new JSFunctions());
		String url = Thread.currentThread().getContextClassLoader().getResource("fp4g/ide/web/index.html").toString();		
		engine.load(url);
		engine.documentProperty().addListener(new ChangeListener<Document>() 
		{
			@Override
			public void changed(ObservableValue<? extends Document> prop, Document oldDoc, Document newDoc)
			{
				enableFirebug(engine);				
			}
		});		
		
	} 	
	
	 private static void enableFirebug(final WebEngine engine)
	 {
		    engine.executeScript("if (!document.getElementById('FirebugLite')){E = document['createElement' + 'NS'] && document.documentElement.namespaceURI;E = E ? document['createElement' + 'NS'](E, 'script') : document['createElement']('script');E['setAttribute']('id', 'FirebugLite');E['setAttribute']('src', 'https://getfirebug.com/' + 'firebug-lite.js' + '#startOpened');E['setAttribute']('FirebugLite', '4');(document['getElementsByTagName']('head')[0] || document['getElementsByTagName']('body')[0]).appendChild(E);E = new Image;E['setAttribute']('src', 'https://getfirebug.com/' + '#startOpened');}"); 
	 }	
}
