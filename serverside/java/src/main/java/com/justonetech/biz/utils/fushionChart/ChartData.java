package com.justonetech.biz.utils.fushionChart;

import java.io.Serializable;

/**
 * chart图表
 */
public class ChartData implements Serializable {
    int chartType;
    String title;
    String[] categoryNames;
    String[] seriesNames;
    Number[][] values;

    public ChartData(String title, String[] categoryNames, String[] seriesNames, Number[][] values) {
        this.title = title;
        this.categoryNames = categoryNames;
        this.seriesNames = seriesNames;
        this.values = values;
    }

    public int getChartType() {
        return chartType;
    }

    public void setChartType(int chartType) {
        this.chartType = chartType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getCategoryNames() {
        return categoryNames;
    }

    public void setCategoryNames(String[] categoryNames) {
        this.categoryNames = categoryNames;
    }

    public String[] getSeriesNames() {
        return seriesNames;
    }

    public void setSeriesNames(String[] seriesNames) {
        this.seriesNames = seriesNames;
    }

    public Number[][] getValues() {
        return values;
    }

    public void setValues(Number[][] values) {
        this.values = values;
    }

    public String toXml() {
        return "";
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("categoryNames\t");
        for (int i = 0; i < seriesNames.length; i++) {
            String seriesName = seriesNames[i];
            sb.append(seriesName + "\t");
        }

        sb.append("\n");

        for (int i = 0; i < categoryNames.length; i++) {
            String categoryName = categoryNames[i];
            sb.append(categoryName + "\t");

            for (int j = 0; j < seriesNames.length; j++) {
                sb.append(getValues()[i][j]).append("\t");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
