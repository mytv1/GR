package giddyhero.soccersystem.server;

import giddyhero.soccersystem.client.GreetingService;
import giddyhero.soccersystem.shared.FieldVerifier;
import giddyhero.soccersystem.shared.model.News;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Position;
import giddyhero.soccersystem.shared.model.Team;

import java.util.List;

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
	
	public void initDataStore(){
		ObjectifyService.register(Position.class);
//		ObjectifyService.register(Nation.class);
		ObjectifyService.register(Player.class);
		ObjectifyService.register(News.class);
		ObjectifyService.register(Team.class);
		createStandardPositions();
	}
	
	
	public void createStandardPositions(){
		LoadType<Position> firstPos = ofy().load().type(Position.class);
//		System.out.println("Count 1: "+firstPos.count());
		if (firstPos.count() != 11) 
		{
			Position[] positions = new Position[11];
			positions[0] = new Position(1,"Goal Keeper");
			positions[1] = new Position(2,"Center Back");
			positions[2] = new Position(3,"Right Back");
			positions[3] = new Position(4,"Left Back");
			positions[4] = new Position(5,"Center Midfielder");
			positions[5] = new Position(6,"Left Midfielder");
			positions[6] = new Position(7,"Right Midfielder");
			positions[7] = new Position(8,"Left Back");
			positions[8] = new Position(9,"Left Foward");
			positions[9] = new Position(10,"Right Foward");
			positions[10] = new Position(11,"Left Foward");
			
			for(int i = 0;i <11;i++){
				ofy().save().entities(positions[i]).now();
			}
		} 
 	}
	
	public Position[] getStandardSoccerPosition(){
		LoadType<Position> firstPos = ofy().load().type(Position.class);
		List<Position> list = firstPos.list();
		Position[] pos = new Position[list.size()];
		for(int i = 0;i < list.size();i++){
			pos[i] = list.get(i);
		}
		return pos;
	}
}
