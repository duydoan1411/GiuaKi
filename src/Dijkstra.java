import java.util.*;

public class Dijkstra {
    private static NodeGraph nodeTrongSoNhoNhat(Set <NodeGraph> choDuyet) {
        NodeGraph nodeChon = null;
        int trongSoNhoNhat = Integer.MAX_VALUE;
        for (NodeGraph NodeGraph: choDuyet) {
            int trongSo = NodeGraph.getTrongSo();
            if (trongSo < trongSoNhoNhat) {
                trongSoNhoNhat = trongSo;
                nodeChon = NodeGraph;
            }
        }
        return nodeChon;
    }

    private static void trongSoNhoNhat(NodeGraph nodeXet, Integer e, NodeGraph nodeDangChon) {
        Integer trongSoNodeDangChon = nodeDangChon.getTrongSo();
        if (trongSoNodeDangChon + e < nodeXet.getTrongSo()) {
            nodeXet.setTrongSo(trongSoNodeDangChon + e);
            LinkedList<NodeGraph> duongDiNganNhat = new LinkedList<NodeGraph>(nodeDangChon.getDuongDiNganNhat());
            duongDiNganNhat.add(nodeDangChon);
            nodeXet.setDuongDiNganNhat(duongDiNganNhat);
        }
    }

    public static Graph process(Graph graph, NodeGraph dinhBatDau) {
        dinhBatDau.setTrongSo(0);
        Set<NodeGraph> daDuyet = new HashSet<>();
        Set<NodeGraph> hangDoi = new HashSet<>();
        hangDoi.add(dinhBatDau);
        while (hangDoi.size() != 0) {
            NodeGraph nodeHienTai = nodeTrongSoNhoNhat(hangDoi);
            hangDoi.remove(nodeHienTai);
            for (Map.Entry<NodeGraph, Integer> dinhKe: nodeHienTai.getNodeKe().entrySet()) {
                NodeGraph nodeKe = dinhKe.getKey();
                Integer e = dinhKe.getValue();
                if (!daDuyet.contains(nodeKe)) {
                    trongSoNhoNhat(nodeKe, e, nodeHienTai);
                    hangDoi.add(nodeKe);
                }
            }
            daDuyet.add(nodeHienTai);
        }
        return graph;
    }

    public static void main(String[] args) {
        NodeGraph nodeA = new NodeGraph("A");
        NodeGraph nodeB = new NodeGraph("B");
        NodeGraph nodeC = new NodeGraph("C");
        NodeGraph nodeD = new NodeGraph("D");
        NodeGraph nodeE = new NodeGraph("E");
        NodeGraph nodeF = new NodeGraph("F");

        nodeA.addDinhKe(nodeB, 10);
        nodeA.addDinhKe(nodeC, 15);

        nodeB.addDinhKe(nodeD, 12);
        nodeB.addDinhKe(nodeF, 15);

        nodeC.addDinhKe(nodeE, 10);

        nodeD.addDinhKe(nodeE, 2);
        nodeD.addDinhKe(nodeF, 1);

        nodeF.addDinhKe(nodeE, 5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = Dijkstra.process(graph, nodeA);

        for(NodeGraph a : graph.getNodes()){
            System.out.print(a.getName()+ ": ");
            for (NodeGraph a1 : a.getDuongDiNganNhat()){
                System.out.print(a1.getName()+"->");
            }
            System.out.print(a.getName()+" "+a.getTrongSo()+"\n");
        }
    }
}
