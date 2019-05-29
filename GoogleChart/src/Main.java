import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.events.FinishLoadingEvent;
import com.teamdev.jxbrowser.chromium.events.LoadAdapter;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

public class Main extends JFrame {
	
	private Browser browser = new Browser();
	private BrowserView browserView = new BrowserView(browser);
	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Google Chart");
		setVisible(true);
		setResizable(false);
		setSize(800,600);
		
		browser.addLoadListener(new LoadAdapter() {
			@Override
			public void onFinishLoadingFrame(FinishLoadingEvent event) {
				if(event.isMainFrame()) {
					System.out.println("HTML 문서 로딩");
				}
			}
			
		}); 
		
		String title = "제목";
		ArrayList<PieElement> list = new ArrayList<PieElement>();
		list.add(new PieElement("모니터", 49));
		list.add(new PieElement("본체", 100));
		list.add(new PieElement("키보드", 200));
		list.add(new PieElement("마우스", 10));
		
		browser.loadHTML(new GoogleAPI().getPieChart(title, list));
		add(browserView, BorderLayout.CENTER);
	}

}
