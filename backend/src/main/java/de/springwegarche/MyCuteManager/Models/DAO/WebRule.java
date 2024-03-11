package de.springwegarche.MyCuteManager.Models.DAO;

import java.util.ArrayList;
import java.util.List;

import de.springwegarche.MyCuteManager.Models.Rule;
import de.springwegarche.MyCuteManager.Models.Topic;
import java.util.Objects;

public class WebRule extends Rule{
    private ArrayList<Integer> parents;
    public static WebRule fromRule(Rule r) {
        ArrayList<Integer> result = new ArrayList<>();

        String[] components = r.getRule().split(" ");
        for (int i = 0; i < components.length; i++) {
            if(components[i].startsWith("{") && components[i].endsWith("}")) {
                components[i] = components[i].substring(1, components[i].length() -1);

                result.add(Integer.parseInt(components[i]));
            }
        }
        
        return new WebRule(r, result);
    }
    private WebRule(Rule r, ArrayList<Integer> parents) {
        super(r.getId(), r.getName(), r.getRule());
        this.parents = parents;
    }

    // generated


    public WebRule() {
    }

    public WebRule(ArrayList<Integer> parents) {
        this.parents = parents;
    }

    public ArrayList<Integer> getParents() {
        return this.parents;
    }

    public void setParents(ArrayList<Integer> parents) {
        this.parents = parents;
    }

    public WebRule parents(ArrayList<Integer> parents) {
        setParents(parents);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WebRule)) {
            return false;
        }
        WebRule webRule = (WebRule) o;
        return Objects.equals(parents, webRule.parents);
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
            " parents='" + getParents() + "'" +
            "}";
    }
    
}
