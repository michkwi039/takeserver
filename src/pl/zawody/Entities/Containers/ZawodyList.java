package pl.zawody.Entities.Containers;

import pl.zawody.Entities.Wyniki;
import pl.zawody.Entities.Zawody;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class ZawodyList {
    private List<Zawody> list;

    public ZawodyList(List<Zawody> list) {
        this.list = list;
    }
    public ZawodyList() {
    }
    public List<Zawody> getList() {
        return list;
    }

    public void setList(List<Zawody> list) {
        this.list = list;
    }
}
