package ilgulee.com.modernizepractice;

import android.os.Parcel;
import android.os.Parcelable;

public class Automobile implements Parcelable {

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

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(maker);
        dest.writeString(model);
    }
}
