package com.jazzteam.borisov.models.build;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "parameterAudience")
public class ParameterAudience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parameterId;
    @Column(name = "parameter_Type")
    private String typeParameter;

    @ManyToMany(mappedBy = "parameterAudienceList", cascade = CascadeType.ALL)
    private Set<Audience> audienceList;

    public ParameterAudience() {
    }

    public ParameterAudience(String typeParameter) {
        this.typeParameter = typeParameter;
        audienceList = new HashSet<>();
    }

    public int getParameterId() {
        return parameterId;
    }

    public void setParameterId(int parameterId) {
        this.parameterId = parameterId;
    }

    public String getTypeParameter() {
        return typeParameter;
    }

    public void setTypeParameter(String typeParameter) {
        this.typeParameter = typeParameter;
    }

    public Set<Audience> getAudienceList() {
        return audienceList;
    }

    public void setAudienceList(Set<Audience> audienceList) {
        this.audienceList = audienceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParameterAudience that = (ParameterAudience) o;
        return parameterId == that.parameterId &&
                Objects.equals(typeParameter, that.typeParameter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameterId, typeParameter);
    }
}
