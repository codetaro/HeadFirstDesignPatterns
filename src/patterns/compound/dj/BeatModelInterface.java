package patterns.compound.dj;

public interface BeatModelInterface {
    void initialize();

    void on();

    void off();

    void setBPM(int bpm);

    // 如果返回值为0，表示节拍器是关闭的
    int getBPM();

    /* 这些方法允许视图和控制器取得状态，并变成观察者 */
    void registerObserver(BeatObserver o);

    void removeObserver(BeatObserver o);

    void registerObserver(BPMObserver o);

    void removeObserver(BPMObserver o);
}
