package ilgulee.com.modernizepractice;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "automobile")
public class Automobile {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    private int id;
    private String maker;
    private String model;

    public Automobile(String maker, String model) {
        this.maker = maker;
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    @NotNull
    public int getId() {
        return id;
    }

    public void setId(@NotNull int id) {
        this.id = id;
    }
}
