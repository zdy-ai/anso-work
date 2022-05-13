package sms.runtime;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @Package: sms.runtime
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/5/12 14:51
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        CommandRunner commandRunner = new CommandRunner();
        Scanner scanner = new Scanner(System.in);
        String line;
        while (!Objects.equals(line = scanner.nextLine(), "quit")) {
            String[] inputs = line.split(",");
            List<Object> parms = Arrays.asList(Arrays.copyOfRange(inputs, 2, inputs.length));
            commandRunner.run(inputs[0], inputs[1],parms);
        }
    }
}
