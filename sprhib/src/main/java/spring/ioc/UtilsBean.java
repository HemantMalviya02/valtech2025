package spring.ioc;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class UtilsBean {
	
	private Set<String> names;
	private List<Point> points;
	private Map<String, Integer> numbers;
	
	private Properties props;
	
	public Properties getProps() {
		return props;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
	
	public Map<String, Integer> getNumbers() {
		return numbers;
	}
	public void setNumbers(Map<String, Integer> numbers) {
		this.numbers = numbers;
	}
	
	
	public void setPoints(List<Point> points) {
		this.points = points;
	}
	public List<Point> getPoints() {
		return points;
	}
	
	
	public void setNames(Set<String> names) {
		this.names = names;
	}
	public Set<String> getNames() {
		return names;
	}
	
}

