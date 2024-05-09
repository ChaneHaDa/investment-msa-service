package com.chan.investment.calculatorservice.dto;

import java.util.List;

public class PortfolioRorDTO {

        private List<Double> rorList;
        private List<Double> weightList;

        public PortfolioRorDTO() {
        }

        public PortfolioRorDTO(List<Double> rorList, List<Double> weightList) {
            this.rorList = rorList;
            this.weightList = weightList;
        }

        public List<Double> getRorList() {
            return rorList;
        }

        public void setRorList(List<Double> rorList) {
            this.rorList = rorList;
        }

        public List<Double> getWeightList() {
            return weightList;
        }

        public void setWeightList(List<Double> weightList) {
            this.weightList = weightList;
        }
}
