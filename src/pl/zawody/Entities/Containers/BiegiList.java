package pl.zawody.Entities.Containers;


import pl.zawody.Entities.Biegi;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
public class BiegiList {
    private List<Biegi> list;

    public List<Biegi> getList() {
        return list;
    }

    public void setList(List<Biegi> list) {
        this.list = list;
    }

    public BiegiList() {
    }

    public BiegiList(List<Biegi> list) {
        this.list = list;
    }
}
