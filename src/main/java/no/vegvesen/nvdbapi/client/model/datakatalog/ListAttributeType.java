package no.vegvesen.nvdbapi.client.model.datakatalog;

public class ListAttributeType extends AttributeType {

    private Integer max;
    private Integer min;
    private AttributeType content;

    public ListAttributeType(AttributeCommonProperties props,
                             AttributeType content,
                             Integer min, Integer max) {
        super(props);
        this.min = min;
        this.max = max;
        this.content = content;
    }

    public AttributeType getContent() {
        return content;
    }

    public Integer getMax() { return max; }

    public Integer getMin() { return min; }

}
