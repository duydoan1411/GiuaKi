import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NodeGraph {

    private String name;

    private List<NodeGraph> duongDiNganNhat = new LinkedList<>();

    private Integer trongSo = Integer.MAX_VALUE;

    Map<NodeGraph, Integer> nodeKe = new HashMap<>();

    public void addDinhKe(NodeGraph dinh, int trongSo) {
        nodeKe.put(dinh, trongSo);
    }

    public NodeGraph(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NodeGraph> getDuongDiNganNhat() {
        return duongDiNganNhat;
    }

    public void setDuongDiNganNhat(List<NodeGraph> duongDiNganNhat) {
        this.duongDiNganNhat = duongDiNganNhat;
    }

    public Integer getTrongSo() {
        return trongSo;
    }

    public void setTrongSo(Integer trongSo) {
        this.trongSo = trongSo;
    }

    public Map<NodeGraph, Integer> getNodeKe() {
        return nodeKe;
    }

    public void setNodeKe(Map<NodeGraph, Integer> nodeKe) {
        this.nodeKe = nodeKe;
    }
}
