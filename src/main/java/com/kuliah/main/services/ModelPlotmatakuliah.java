package com.kuliah.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuliah.main.entity.PlotMataKuliah;
import com.kuliah.main.repository.PlotMataKuliahRepository;

@Service
public class ModelPlotmatakuliah  implements ModelPlotmatakuliahInterface{
	
	@Autowired
	PlotMataKuliahRepository plotRepo;

	@Override
	public List<PlotMataKuliah> getAllPlotMataKuliah() {
		// TODO Auto-generated method stub
		return (List<PlotMataKuliah>) this.plotRepo.findAll();
	}

	

	@Override
	public PlotMataKuliah addPlotMataKuliah(PlotMataKuliah plotmatakuliah) {
		// TODO Auto-generated method stub
		
		return  this.plotRepo.save(plotmatakuliah);
	
	}

	@Override
	public PlotMataKuliah cariPlot(String id) {
		// TODO Auto-generated method stub
		return this.plotRepo.findById(Long.parseLong(id)).get();
	}
	
	
	

	@Override
	public void deletePlot(String id) {
		// TODO Auto-generated method stub
		this.plotRepo.deleteById(Long.parseLong(id));
		
	}

}
