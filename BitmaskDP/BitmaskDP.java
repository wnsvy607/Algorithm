import java.util.Random;

public class BitmaskDP {

	public static void main(String[] args) {
		// --- 최대값 랜덤 테스트 케이스 (N=12, M=100, K=50) ---
		int N = 12, M = 100, K = 50;
		String[] randomArr = generateRandomBitArrays(M, N);
		System.out.println("Random Test (N=" + N +",M=" + M +",K=" + K + "): " + dp(randomArr, K));
	}

	public static int dp(String[] bitArrays, int K) {
		int M = bitArrays.length;
		int N = bitArrays[0].length();
		int full = 1 << N;

		// 문자열 → 비트마스크 정수
		int[] masks = new int[M];
		for (int i = 0; i < M; i++) {
			masks[i] = bitmaskFromString(bitArrays[i]);
		}

		// dp[j][mask]
		boolean[][] dp = new boolean[K+1][full];
		dp[0][0] = true;

		// 각 아이템마다 DP 갱신 순서대로 진행해서 모든 경우의 수 탐색 가능
		for (int i = 0; i < M; i++) {
			int b = masks[i];
			// j를 뒤에서부터 순회해야 중복 사용을 막을 수 있다.
			for (int j = Math.min(K, i+1); j >= 1; j--) {
				for (int mask = 0; mask < full; mask++) {
					if (dp[j-1][mask]) {
						dp[j][mask | b] = true;
					}
				}
			}
		}


		// dp[K][*] 중 true인 개수를 세어서 반환
		int cnt = 0;
		for (int mask = 0; mask < full; mask++) {
			if (dp[K][mask]) cnt++;
		}
		return cnt;
	}

	// 비트 문자열을 int형으로 변환
	private static int bitmaskFromString(String s) {
		int mask = 0, len = s.length();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '1') {
				mask |= (1 << (len - 1 - i));
			}
		}
		return mask;
	}

	// 랜덤한 비트 어레이를 만드는 메서드
	private static String[] generateRandomBitArrays(int M, int N) {
		String[] arr = new String[M];
		Random rnd = new Random();
		for (int i = 0; i < M; i++) {
			StringBuilder sb = new StringBuilder(N);
			for (int j = 0; j < N; j++) {
				sb.append(rnd.nextInt(2));
			}
			arr[i] = sb.toString();
		}
		return arr;
	}
}
