package de.springwegarche.MyCuteManager.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "RULES")
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;

    @Column(name = "rule")
    private String rule = "";


    // generated

    public Rule() {
    }

    public Rule(long id, String name, String rule) {
        this.id = id;
        this.name = name;
        this.rule = rule;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRule() {
        return this.rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public Rule id(long id) {
        setId(id);
        return this;
    }

    public Rule name(String name) {
        setName(name);
        return this;
    }

    public Rule rule(String rule) {
        setRule(rule);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Rule)) {
            return false;
        }
        Rule rule = (Rule) o;
        return id == rule.id && Objects.equals(name, rule.name) && Objects.equals(rule, rule.rule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rule);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", rule='" + getRule() + "'" +
            "}";
    }
    
}
