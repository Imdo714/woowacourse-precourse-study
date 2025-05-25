package model;

import view.OutputView;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static model.Rank.MISS;

public class LottoList {

    private List<Lotto> lottos;


    public LottoList(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Rank> matchAll(Winning winning) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(winning, lotto); // 몇개의 번호가 맞는지
            boolean bonusMatch = isBonusMatch(winning, lotto);

            ranks.add(Rank.of(matchCount, bonusMatch));

            // 디버깅 용
            System.out.println("===================== START =======================");
            System.out.println("로또 번호: " + lotto.getNumbers());
            System.out.println("일치 개수: " + matchCount + ", 보너스 일치: " + bonusMatch);
            System.out.println("Rank: " + ranks);
            System.out.println("===================== END =======================");
            System.out.println();
        }

        return ranks;
    }

    private int getMatchCount(Winning winning, Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(c -> winning.winningContains(c)) // 당첨 번호랑 같은지 비교
                .count();
    }

    private boolean isBonusMatch(Winning winning, Lotto lotto) {
        return lotto.getNumbers().contains(winning.getBonus()); // 보너스 번호가 있으면 TRUE
    }

    public Map<Rank, Integer> summarize(List<Rank> results) { //  Rank가 몇 개 있는지 확인
        Map<Rank, Integer> stats = new EnumMap<>(Rank.class); // enum 전용 Map으로, 성능이 더 좋고 메모리 사용이 효율적임

        for (Rank rank : results) {
            stats.put(rank, stats.getOrDefault(rank, 0) + 1); // rank가 있으면 +1 없으면 0
            // getOrDefault : 찾는 key가 존재한다면 찾는 key의 value를 반환하고 없거나 null이면 default 값을 반환한다.
        }
        return stats;
    }

    public int calculateTotalReward(Map<Rank, Integer> stats) { // 당첨금 계산
        int total = 0;

        for (Rank rank : Rank.values()) { // Rank.values()는 Rank enum의 모든 등수 순회
            if (isaRankMiss(rank)) continue;
            total += stats.getOrDefault(rank, 0) * rank.getReward(); // rank 가 없으면 (0 * Reward) 있으면 (수량 * Reward)
        }
        return total;
    }

    public void printStats(Map<Rank, Integer> resultStats, OutputView outputView) {
        for (Rank rank : Rank.values()) {
            if (isaRankMiss(rank)) continue;

            int count = resultStats.getOrDefault(rank, 0); // 랭크 수량 즉, 당첨 갯수
            outputView.printStatistics(rank.getMessage(), rank.getReward(), count);
        }
    }

    private static boolean isaRankMiss(Rank rank) {
        return rank == MISS;
    }

    public void printLottoNumbers(OutputView outputView) {
        for (Lotto lotto : lottos) {
            outputView.printLottoNumbers(lotto);
        }
    }
}
