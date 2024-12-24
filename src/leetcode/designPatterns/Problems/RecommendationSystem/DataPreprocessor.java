package leetcode.designPatterns.Problems.RecommendationSystem;

public abstract class DataPreprocessor {
    protected DataPreprocessor nextPreprocessor;

    public abstract void preprocess(String data);

    public void setNext(DataPreprocessor nextPreprocessor) {
        this.nextPreprocessor = nextPreprocessor;
    }
}
