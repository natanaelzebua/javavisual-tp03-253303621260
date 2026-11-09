import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Inisialisasi Controller / Manager
        CharacterManager manager = new CharacterManager();

        // Menambahkan minimal 5 Karakter (termasuk 2 karakter baru)
        manager.addCharacter(new Character("Arthur", CharacterType.WARRIOR, 10));
        manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 15));
        manager.addCharacter(new Character("Robin", CharacterType.ARCHER, 8));
        manager.addCharacter(new Character("Galahad", CharacterType.HEALER, 12));
        manager.addCharacter(new Character("Morgana", CharacterType.MAGE, 25)); // Diubah ke level 25

        // Menjalankan GUI secara aman di dalam Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}