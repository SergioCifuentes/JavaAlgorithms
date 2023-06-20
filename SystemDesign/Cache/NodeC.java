public class NodeC {
	public NodeC prev;
	public NodeC next;
	public String[] results;
	public String query;

	public NodeC(String q, String[] res) {
		results = res;
		query = q;
	}
}
