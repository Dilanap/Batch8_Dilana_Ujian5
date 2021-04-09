package com.kuliah.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kuliah.main.entity.PlotMataKuliah;
import com.kuliah.main.entity.Dosen;
import com.kuliah.main.entity.Mahasiswa;
import com.kuliah.main.entity.MataKuliah;
import com.kuliah.main.entity.Soal;
import com.kuliah.main.services.ModelPlotmatakuliah;
import com.kuliah.main.services.ModelDosen;
import com.kuliah.main.services.ModelSoal;
import com.kuliah.main.services.ModelMahasiswa;
import com.kuliah.main.services.ModelMataKuliah;
@Controller
public class PlotmatakuliahPage {
	
	@Autowired
	ModelPlotmatakuliah modelplot;
	@Autowired
	ModelDosen modelDosen;
	
	@Autowired
	ModelSoal modelsoal;
	
	@Autowired
	ModelMataKuliah modelMatkul;
	
	
	@Autowired
	ModelMahasiswa modelmahasiswa;
	@GetMapping("/plotmatakuliah/view")
	public String viewIndexplot(Model model) {
		
		model.addAttribute("listPlotmatakuliah",modelplot.getAllPlotMataKuliah());
		model.addAttribute("active",5);
		return "view_plotmatakuliah";
	}
	
	
	@GetMapping("/plotmatakuliah/add")
	public String viewAddPlotMataKuliah(Model model) {
		
		// buat penampung data Dosen di halaman htmlnya
		model.addAttribute("plotmatakuliah",new PlotMataKuliah());
		model.addAttribute("listPlotmatakuliah",modelplot.getAllPlotMataKuliah());
		model.addAttribute("listDosen", modelDosen.getAllDosen());
		model.addAttribute("listMatkul", modelMatkul.getAllMataKuliah());
		model.addAttribute("listMhs", modelmahasiswa.getAllMahasiswa());
		model.addAttribute("listsoal", modelsoal.getAllSoal());
		
		return "add_plotmatakuliah";
	}
	
	@PostMapping("/plotmatakuliah/view")
	  public String addPlotMataKuliah(@ModelAttribute PlotMataKuliah PlotMataKuliah, Model model) {
		
		// buat penampung data Dosen di halaman htmlnya
		this.modelplot.addPlotMataKuliah(PlotMataKuliah);
		model.addAttribute("listPlotMataKuliah",modelplot.getAllPlotMataKuliah());
		
		
		return "redirect:/plotmatakuliah/view";
	}
	
	
	@GetMapping("/plotmatakuliah/update/{id}")
	public String viewUpdatePlotMataKuliah(@PathVariable String id, Model model) {
		
		PlotMataKuliah plotMataKuliah = modelplot.cariPlot(id);
		// buat penampung data mahasiswa di halaman htmlnya
		model.addAttribute("plotmatakuliah",plotMataKuliah);
		model.addAttribute("listPlotmatakuliah",modelplot.getAllPlotMataKuliah());
		model.addAttribute("listDosen", modelDosen.getAllDosen());
		model.addAttribute("listMatkul", modelMatkul.getAllMataKuliah());
		model.addAttribute("listMhs", modelmahasiswa.getAllMahasiswa());
		model.addAttribute("listsoal", modelsoal.getAllSoal());
		
		return "add_plotmatakuliah";
	}
	
	
	@GetMapping("/plotmatakuliah/delete/{id}")
	public String deletePlot(@PathVariable String id, Model model) {
		
		this.modelplot.deletePlot(id);
		model.addAttribute("listPlotMataKuliah",modelplot.getAllPlotMataKuliah());
		
		
		return "redirect:/plotmatakuliah/view";
	}

}