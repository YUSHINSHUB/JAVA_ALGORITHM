package Geometry;

import java.util.Objects;

public class pos {
	int x;
	int y;

	pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// 객체 간의 동일성을 확인 (Check for object equality)
		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			pos position = (pos) o;
			return x == position.x && y == position.y;
		}

		// 객체의 해시 코드 생성 (Generate hash code for the object)
		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
}
