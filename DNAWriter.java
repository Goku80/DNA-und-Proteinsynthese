import java.io.FileWriter;
import java.io.IOException;

// Klasse zum Schreiben von DNA-Daten in eine CSV-Datei
public class DNAWriter {

    // Hauptmethode zum Ausführen des Programms
    public static void main(String[] args) throws IOException {

        // DNA-Daten als zweidimensionales Array von Zeichenfolgen
        String[][] data = {
                {"Alanine", "AAT"},
                {"Alanine", "AAC"},
                {"Alanine", "GCT"},
                {"Alanine", "GCC"},
                {"Alanine", "GCA"},
                {"Alanine", "GCG"},
                {"Arginine", "CGT"},
                {"Arginine", "CGC"},
                {"Arginine", "CGA"},
                {"Arginine", "CGG"},
                {"Arginine", "AGA"},
                {"Arginine", "AGG"},
                {"Aspartic Acid", "GAT"},
                {"Aspartic Acid", "GAC"},
                {"Cysteine", "TGT"},
                {"Cysteine", "TGC"},
                {"Glutamic Acid", "GAA"},
                {"Glutamic Acid", "GAG"},
                {"Glutamine", "CAA"},
                {"Glutamine", "CAG"},
                {"Glycine", "GGT"},
                {"Glycine", "GGC"},
                {"Glycine", "GGA"},
                {"Glycine", "GGG"},
                {"Histidine", "CAT"},
                {"Histidine", "CAC"},
                {"Isoleucine", "ATT"},
                {"Isoleucine", "ATC"},
                {"Isoleucine", "ATA"},
                {"Leucine", "TTA"},
                {"Leucine", "TTG"},
                {"Leucine", "CTT"},
                {"Leucine", "CTC"},
                {"Leucine", "CTA"},
                {"Leucine", "CTG"},
                {"Lysine", "AAA"},
                {"Lysine", "AAG"},
                {"Methionine", "ATG"},
                {"Phenylalanine", "TTT"},
                {"Phenylalanine", "TTC"},
                {"Proline", "CCT"},
                {"Proline", "CCC"},
                {"Proline", "CCA"},
                {"Proline", "CCG"},
                {"Serine", "TCT"},
                {"Serine", "TCA"},
                {"Serine", "TCG"},
                {"Serine", "AGT"},
                {"Serine", "AGC"},
                {"Serine", "TCC"},
                {"Stop", "TAA"},
                {"Stop", "TAG"},
                {"Stop", "TGA"},
                {"Threonine", "ACT"},
                {"Threonine", "ACC"},
                {"Threonine", "ACA"},
                {"Threonine", "ACG"},
                {"Tyrosine", "TAT"},
                {"Tyrosine", "TAC"},
                {"Tryptophan", "TGG"},
                {"Valine", "GTT"},
                {"Valine", "GTC"},
                {"Valine", "GTA"},
                {"Valine", "GTG"}
        };

        String csvFilePath = "codes.csv"; // Pfad zur CSV-Datei
        FileWriter csvWriter = new FileWriter(csvFilePath); // FileWriter zum Schreiben in die Datei erstellen

        // Schleife zum Durchlaufen der DNA-Daten und Schreiben in die CSV-Datei
        for (String[] row : data) {
            csvWriter.append(row[0]); // Name des Aminosäure-Codons
            csvWriter.append(","); // Trennzeichen
            csvWriter.append(row[1]); // DNA-Code des Aminosäure-Codons
            csvWriter.append("\n"); // Neue Zeile
        }

        csvWriter.close(); // FileWriter schließen

        // Ausgabe nach erfolgreichem Schreiben der CSV-Datei
        System.out.println("Die CSV-Datei wurde erfolgreich erstellt: " + csvFilePath);
    }
}
