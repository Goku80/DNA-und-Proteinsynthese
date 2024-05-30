import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

// Klasse zum Lesen von DNA-Sequenzen und Übersetzen in Aminosäuren mithilfe eines Code-zu-Aminosäure-Wörterbuchs
public class DNAReader {

    // Methode zum Übersetzen einer DNA-Sequenz in Aminosäuren
    public static void translateDNA(String dna, HashMap<String, String> codeToAmino) {
        StringBuilder protein = new StringBuilder(); // StringBuilder zum Speichern der Aminosäuresequenz
        int count = 1; // Zählvariable für die Aminosäuresequenzen

        var pattern = Pattern.compile(".{3}"); // Pattern zum Aufteilen der DNA in Triplets (Codons)
        var matcher = pattern.matcher(dna); // Matcher für das DNA-Muster

        while (matcher.find()) {
            var triplet = matcher.group(0); // Aktuelles Codon
            var amino = codeToAmino.get(triplet); // Aminosäure für das Codon aus dem Wörterbuch

            // Überprüfung, ob das Codon ein Stopp-Codon ist
            if (amino.equals("Stop")) {
                System.out.println(count + ": " + protein); // Ausgabe der Aminosäuresequenz
                protein.setLength(0); // Reset des StringBuilder für die nächste Sequenz
                count++; // Zähler erhöhen
            } else {
                if (!protein.isEmpty()) {
                    protein.append("--"); // Trennzeichen zwischen Aminosäuren hinzufügen
                }
                protein.append(amino); // Aminosäure zum Protein hinzufügen
            }
        }
    }

    // Hauptmethode zum Ausführen des Programms
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, String> codeToAmino = new HashMap<String, String>(); // Wörterbuch für Codon zu Aminosäure Übersetzung
        String csvFilePath = "codes.csv"; // Pfad zur CSV-Datei mit Codon-Aminosäure Zuordnungen
        Scanner scan = new Scanner(new File(csvFilePath)); // Scanner zum Lesen der CSV-Datei

        // Einlesen der Codon-Aminosäure Zuordnungen aus der CSV-Datei
        while (scan.hasNext()) {
            var line = scan.nextLine(); // Aktuelle Zeile der CSV-Datei
            String[] parts = line.split(","); // Aufteilen der Zeile anhand des Trennzeichens ","
            var amino = parts[0]; // Aminosäure aus der Zeile
            var triplet = parts[1]; // Codon aus der Zeile

            codeToAmino.put(triplet, amino); // Eintrag in das Wörterbuch hinzufügen
        }
        scan.close(); // Scanner schließen

        // Beispiel-DNA-Sequenz
        String dna = "ACAAGATGCCATTGTCCCCCGGCCTCCTGCTGCTGCTGCTCTCCGGGGCCACGGCCACCGCTGCCCTGCCCCTGGA" +
                "GGGTGGCCCCACCGGCCGAGACAGCGAGCATATGCAGGAAGCGGCAGGAATAAGGAAAAGCAGCCTCCTGACTTTC" +
                "CTCGCTTGGTGGTTTGAGTGGACCTCCCAGGCCAGTGCCGGGCCCCTCATAGGAGAGGAAGCTCGGGAGGTGGCCA" +
                "GGCGGCAGGAAGGCGCACCCCCCCAGCAATCCGCGCGCCGGGACAGAATGCCCTGCAGGAACTTCTTCTGGAAGAC" +
                "CTTCTCCTCCTGCAAATAAAACCTCACCCATGAATGCTCACGCAAGTTTAATTACAGACCTGTGA";

        translateDNA(dna, codeToAmino); // Aufruf der Übersetzungsmethode
    }
}
