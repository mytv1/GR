package giddyhero.soccersystem.server;

import giddyhero.soccersystem.client.GreetingService;
import giddyhero.soccersystem.shared.FieldVerifier;
import giddyhero.soccersystem.shared.Position;
import giddyhero.soccersystem.shared.model.News;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

import java.util.List;
import java.util.Locale;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.LoadType;
import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {
	

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
	
	public void registerAllEntity(){
//		ObjectifyService.register(Nation.class);
		ObjectifyService.register(Player.class);
		ObjectifyService.register(News.class);
		ObjectifyService.register(Team.class);
	}

	@Override
	public String[] getAllCountryNames() {
		String[] locales = Locale.getISOCountries();
		String[] countriesName = new String[locales.length];
		 
		for (int i = 0;i < locales.length;i++) {
			String countryCode = locales[i];
			Locale obj = new Locale("", countryCode);
			countriesName[i] = obj.getDisplayCountry();
	 
		}
		return countriesName;
	}
	
}
