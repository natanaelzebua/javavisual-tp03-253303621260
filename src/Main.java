import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Character Manager v0.2 - CRUD Test ===\n");
        
        CharacterManager manager = new CharacterManager();
        
        // 1. Membuat karakter
        Character hero = new Character("Arjuna", CharacterType.WARRIOR, 5);
        Character wizard = new Character("Merlin", CharacterType.MAGE, 3);
        Character scout = new Character("Athena", CharacterType.ARCHER, 4);
        
        // 2. Menambahkan karakter (Create)
        manager.addCharacter(hero);
        manager.addCharacter(wizard);
        manager.addCharacter(scout);
        System.out.println();
        
        // 3. Menguji duplikat
        Character duplicateHero = new Character("Arjuna", CharacterType.WARRIOR, 5);
        manager.addCharacter(duplicateHero);
        System.out.println();
        
        // 4. Menampilkan total
        System.out.println("Total karakter saat ini: " + manager.getTotalCharacters() + "\n");
        
        // 5. Pencarian (Read)
        System.out.println("--- Pencarian ---");
        Character found = manager.findByName("Merlin");
        if (found != null) {
            System.out.println("Ditemukan: " + found);
        }
        
        Character notFound = manager.findByName("Zeus");
        if (notFound == null) {
            System.out.println("Zeus tidak ditemukan (sesuai harapan)");
        }
        System.out.println();
        
        // 6. Penghapusan (Delete)
        System.out.println("--- Penghapusan ---");
        if (manager.removeCharacter("Athena")) {
            System.out.println("🗑️ Karakter 'Athena' berhasil dihapus.");
        }
        System.out.println("Total setelah hapus: " + manager.getTotalCharacters() + "\n");
        
        // 7. Daftar Karakter Tersisa
        System.out.println("--- Daftar Karakter Tersisa ---");
        for (Character c : manager.getAllCharacters()) {
            System.out.println(c);
        }
    }
}