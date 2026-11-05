package com.unpri.charactermanager.model;

/**
 * Merepresentasikan satu karakter dalam aplikasi Character Manager.
 * Menerapkan prinsip Encapsulation: semua atribut private,
 * akses hanya melalui getter/setter.
 */
public class Character {
    // ===== ATRIBUT (private — tidak bisa diakses langsung dari luar class) =====
    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    
    // TANTANGAN P3: Tambahan atribut private mana
    private int mana;

    // ===== CONSTRUCTOR 1: untuk membuat karakter BARU =====
    public Character(String name, CharacterType type, int level) {
        this.name = name;              
        this.type = type;
        this.level = level;
        this.hitPoints = calculateBaseHP();      
        this.attackPower = calculateBaseAttack(); 
        this.mana = 50; // Nilai default mana untuk karakter baru
    }

    // ===== CONSTRUCTOR 2: untuk MEMUAT karakter dari database =====
    public Character(int id, String name, CharacterType type, int level, int hitPoints, int attackPower, int mana) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        setMana(mana); // Menggunakan setter untuk memvalidasi mana
    }

    // ===== HELPER PRIVATE: hanya dipakai internal class ini =====
    private int calculateBaseHP() {
        return 100 + (level * 10);   
    }

    private int calculateBaseAttack() {
        return 10 + (level * 5);     
    }

    // ===== GETTER: cara AMAN membaca nilai atribut private dari luar =====
    public int getId() { return id; }
    public String getName() { return name; }
    public CharacterType getType() { return type; }
    public int getLevel() { return level; }
    public int getHitPoints() { return hitPoints; }
    public int getAttackPower() { return attackPower; }
    
    // TANTANGAN P3: Getter untuk mana
    public int getMana() { return mana; }

    // ===== SETTER: cara AMAN mengubah atribut, dengan VALIDASI =====
    public void setId(int id) {
        this.id = id;
    }

    public void setLevel(int level) {
        if (level < 1) {                       
            throw new IllegalArgumentException("Level minimal adalah 1");
        }
        this.level = level;
        this.hitPoints = calculateBaseHP();      
        this.attackPower = calculateBaseAttack();
    }
    
    // TANTANGAN P3: Setter untuk mana dengan validasi
    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh negatif");
        }
        this.mana = mana;
    }
    
    // TANTANGAN P3: Method isAlive
    public boolean isAlive() {
        return this.hitPoints > 0;
    }

    // ===== toString(): representasi teks object =====
    // TANTANGAN P3: Menambahkan mana dan status isAlive() ke dalam output
    @Override
    public String toString() {
        return "Character{id=" + id +
               ", name='" + name + '\'' +
               ", type=" + type +
               ", level=" + level +
               ", hp=" + hitPoints +
               ", atk=" + attackPower + 
               ", mana=" + mana + 
               ", isAlive=" + isAlive() + '}';
    }
     // ===== equals(): membandingkan ISI DATA, bukan alamat memori =====
    // Dua Character dianggap "sama" jika NAMA-nya identik (case-sensitive)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;                    // optimasi: jika memang object yang sama persis
        if (!(obj instanceof Character)) return false;    // jika bukan Character, pasti tidak sama
        Character other = (Character) obj;                // casting aman karena sudah dicek instanceof
        return this.name.equals(other.name);               // bandingkan isi atribut name (String punya equals sendiri)
    }
}