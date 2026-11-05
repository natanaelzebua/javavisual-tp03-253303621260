import com.unpri.charactermanager.model.Character;       
import com.unpri.charactermanager.model.CharacterType;   

public class Main {
    public static void main(String[] args) {              
        System.out.println("=== Character Manager v0.1 ===");
        
        // Membuat 3 object Character menggunakan constructor pertama
        Character hero = new Character("Arjuna", CharacterType.WARRIOR, 5);
        Character wizard = new Character("Merlin", CharacterType.MAGE, 3);
        Character scout = new Character("Athena", CharacterType.ARCHER, 4);
        
        // Menampilkan ketiganya menggunakan toString()
        System.out.println(hero);
        System.out.println(wizard);
        System.out.println(scout);
        
        System.out.println();
        System.out.println(">> " + hero.getName() + " level up!");
        hero.setLevel(hero.getLevel() + 1);     
        System.out.println("After level up: " + hero);
        
        System.out.println();
        System.out.println(">> Nama karakter: " + hero.getName());
        System.out.println(">> Jenis karakter: " + hero.getType());
        System.out.println(">> HP saat ini: " + hero.getHitPoints());

        // --- TANTANGAN P3: Uji Coba isAlive dan Mana ---
        System.out.println("\n=== Uji Coba Mini-Challenge ===");
        Character necromancer = new Character("Hades", CharacterType.MAGE, 10);
        necromancer.setMana(150);
        
        System.out.println(necromancer);
        System.out.println("Apakah " + necromancer.getName() + " masih hidup? " + necromancer.isAlive());
        
        // Simulasi karakter mati
        System.out.println("\n>> Hades terkena serangan fatal!");
        Character deadHero = new Character(1, "Hades", CharacterType.MAGE, 10, 0, 60, 0);
        System.out.println(deadHero);
        System.out.println("Apakah " + deadHero.getName() + " masih hidup? " + deadHero.isAlive());
    }
}