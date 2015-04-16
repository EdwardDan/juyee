package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BasePollingUnlawfulProject;


public class PollingUnlawfulProject extends BasePollingUnlawfulProject {
	private static final long serialVersionUID = 1L;

    private String photoPaths;

    private Double distance;

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getPhotoPaths() {
        return photoPaths;
    }

    public void setPhotoPaths(String photoPaths) {
        this.photoPaths = photoPaths;
    }

    /*[CONSTRUCTOR MARKER BEGIN]*/
	public PollingUnlawfulProject() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PollingUnlawfulProject(Long id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/


}