package chatbot;

import java.util.Scanner;

/**
 * Creates a Bot and makes it chat.
 * 
 * @author Natacha Gabbamonte
 * @author Gabriel Gheorghian
 * 
 */
public class ChatBotTUIApp {

	public static void main(String[] args) {
		System.out.println("Welcome to CHATBOT");
		String question;
		boolean askAQuestion = true;
		Scanner keyboard = new Scanner(System.in);
		Bot bot = new Bot();
		do {
			System.out
					.println("Tell Chatbox something (enter Goodbye to leave): ");
			question = keyboard.nextLine();
			if (question.equalsIgnoreCase("goodbye")
					|| question.equalsIgnoreCase("bye")
					|| question.equalsIgnoreCase("good bye")
					|| question.equalsIgnoreCase("cya")
					|| question.equalsIgnoreCase("see ya")
					|| question.equalsIgnoreCase("see you")) {
				askAQuestion = false;
			} else
				System.out.println("Bot says: \"" + bot.ask(question) + "\"");
		} while (askAQuestion);
		keyboard.close();
		System.out.println("Bot says: \"Goodbye!\"");
	}
}
