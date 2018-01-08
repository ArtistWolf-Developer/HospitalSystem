
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.iii.command.AdmitCommand;
import org.iii.command.Command;
import org.iii.command.RegisterCommand;
import org.iii.command.ShowCommand;
import org.iii.command.TreatCommand;
import org.iii.domain.Hospital;
import org.iii.domain.Message;
import org.iii.utils.ApplicationUtils;

public class Main {

	public static void main(String[] args) throws IOException{

		if(args ==null || (args!= null && args.length==0)){
			args = new String[1];
			args[0] = "C://sampleInput";
		}

		File inputFile = ApplicationUtils.getDataSource(args[0]);
		if (inputFile != null) {

			String content = ApplicationUtils.parseFile(inputFile);
			List<String> inputList = ApplicationUtils.parseFromContent(content);

			Hospital hospital = new Hospital();
			for(String input : inputList){
				Message message = parseMessage(input);
				Command command = generateCommand(message, hospital);
				if (command != null){
					hospital.executeCommand(command);
				} else {
					System.out.println("not regular command!");
				}
			}
		} else {
			System.out.println("File not found");
		}
	}

	private static Message parseMessage(String inputMessage){
		List<String> tokens = new LinkedList<String>();
		String[] sArray = inputMessage.trim().split(" ");
		Collections.addAll(tokens, sArray);
		Message message = new Message(tokens);
		return message;
	}

	private static Command generateCommand(Message message, Hospital hospital){
		// ¨ÌMessage§PÂ_¬O­þ¤@ºØCommand
		if (Command.COMMAND_REGISTER.equalsIgnoreCase(message.getType())){
			return RegisterCommand.getInstanceByMessage(message, hospital);
		} else if (Command.COMMAND_ADMIT.equalsIgnoreCase(message.getType())){
			return AdmitCommand.getInstanceByMessage(message, hospital);
		} else if (Command.COMMAND_TREAT.equalsIgnoreCase(message.getType())){
			return TreatCommand.getInstanceByMessage(message, hospital);
		} else if (Command.COMMAND_SHOW.equalsIgnoreCase(message.getType())){
			return ShowCommand.getInstanceByMessage(message, hospital);
		} else {
			return null;
		}
	}

}
