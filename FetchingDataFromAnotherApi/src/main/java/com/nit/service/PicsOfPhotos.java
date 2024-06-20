package com.nit.service;

import java.util.List;

import lombok.Data;

@Data
public class PicsOfPhotos {

	private int id;
	private int sol;
	private Camera camera;
	private String img_src;
	private String earth_date;
}
