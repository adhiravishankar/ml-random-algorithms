import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"type", "file"})
public class EmailRecord {

    String type;
    String file;

    public EmailRecord() {

    }

    public EmailRecord(String type, String file) {
        this.type = type;
        this.file = file;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "EmailRecord{" +
                "type='" + type + '\'' +
                ", file='" + file + '\'' +
                '}';
    }
}
