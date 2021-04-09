package com.kuliah.main.services;

import java.util.List;
import java.util.Optional;

import com.kuliah.main.entity.PlotMataKuliah;

public interface ModelPlotmatakuliahInterface {
	
	public List<PlotMataKuliah> getAllPlotMataKuliah();
	
	
	public PlotMataKuliah addPlotMataKuliah(PlotMataKuliah mahasiswa);
	
	public void deletePlot(String id);
	
	public PlotMataKuliah cariPlot(String id);

}


