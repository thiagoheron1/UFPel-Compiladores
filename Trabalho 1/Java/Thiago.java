import java.io.*;

class Thiago {

    public static void main(String[] args) throws Exception {
        BufferedReader arquivo = new BufferedReader(new FileReader(args[0]));

        for (int i = 1; i < 3; i++) {
            arquivo.mark(i);
            System.out.println((char) arquivo.read());
            arquivo.reset();
            System.out.println((char) arquivo.read());
        }

    }

}
