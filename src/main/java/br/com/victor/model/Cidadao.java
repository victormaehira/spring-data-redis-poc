package br.com.victor.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Cidadao implements Serializable {

    public static final String CACHE_NAME = "Cidadao";

    @Id
    private String idn;
    private String psbioName;

    public String getIdn() {
        return idn;
    }

    public void setIdn(String idn) {
        this.idn = idn;
    }

    public String getPsbioName() {
        return psbioName;
    }

    public void setPsbioName(String psbioName) {
        this.psbioName = psbioName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidadao cidadao = (Cidadao) o;
        return Objects.equals(idn, cidadao.idn) &&
                Objects.equals(psbioName, cidadao.psbioName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idn, psbioName);
    }
}
