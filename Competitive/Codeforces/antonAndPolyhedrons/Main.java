import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nTestCases = in.nextInt();

        Map<String, Integer> polys = new HashMap<String, Integer>();
        polys.put("Tetrahedron", 4);
        polys.put("Cube", 6);
        polys.put("Octahedron", 8);
        polys.put("Dodecahedron", 12);
        polys.put("Icosahedron", 20);

        in.nextLine(); // skip the newline character

        int nFaces = 0;
        for (int i = 0; i < nTestCases; i++) {
            String polyhedron = in.nextLine();
            nFaces += polys.get(polyhedron);
        }

        System.out.println(nFaces);
    }
}