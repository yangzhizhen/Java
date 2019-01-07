package pattern;

import java.io.IOException;

public class RuntimeTest01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stubF
		Runtime r = Runtime.getRuntime();
		r.exec("ls");
	}
}