package ilgulee.com.modernizepractice;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "automobile")
public class Automobile implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    private int id;
    private String maker;
    private String model;

    public Automobile(String maker, String model) {
        this.maker = maker;
        this.model = model;
    }

    protected Automobile(Parcel in) {
        maker = in.readString();
        model = in.readString();
    }

    public static final Creator<Automobile> CREATOR = new Creator<Automobile>() {
        @Override
        public Automobile createFromParcel(Parcel in) {
            return new Automobile(in);
        }

        @Override
        public Automobile[] newArray(int size) {
            return new Automobile[size];
        }
    };

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @NotNull
    public int getId() {
        return id;
    }

    public void setId(@NotNull int id) {
        this.id = id;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(maker);
        dest.writeString(model);
    }
}
