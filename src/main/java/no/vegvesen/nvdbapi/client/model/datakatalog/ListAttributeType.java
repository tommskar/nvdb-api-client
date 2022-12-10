package no.vegvesen.nvdbapi.client.model.datakatalog;

public class ListAttributeType extends AttributeType {

    private final Integer max;
    private final Integer min;
    private final AttributeType content;

    public ListAttributeType(AttributeCommonProperties props,
                             AttributeType content,
                             Integer max, Integer min) {
        super(props);
        this.max = max;
        this.min = min;
        this.content = content;
    }

    public AttributeType getContent() {
        return content;
    }

    public Integer getMax() { return max; }

    public Integer getMin() { return min; }

}
