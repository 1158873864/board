package data;


import dataService.IOService;

import java.io.*;

public class IO implements IOService {
	private static IO io;
	public IO(){}

	public static IO getInstance(){
		if(null==io){
			io=new IO();
		}
		return io;
	}

	@Override
	public boolean writeFile(String file,String fileName) {
		File f = new File("src/main/java/record/"+fileName+".txt");
		try {
			if(!f.exists()){
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f, true);
			fw.write(file);
			fw.flush();
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String readFile(String fileName) {
		// TODO Auto-generated method stub
		File f=new File("src/main/java/record/"+fileName+".txt");
		String ret="";
		try{
			FileReader fr=new FileReader(f);
			@SuppressWarnings("resource")
			BufferedReader reader=new BufferedReader(fr);
			String line=null;
			while((line=reader.readLine())!=null){
				ret=ret+line;
			}
		
			fr.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public String readFileList() {
		// TODO Auto-generated method stub
		String ret="";
		File dir=new File("src/main/java/record/");
		dir.mkdirs();
		if(dir.isDirectory()){
			String[] dirContents=dir.list();
			for(int i=0;i<dirContents.length;i++){
				ret=ret+dirContents[i]+"\n";
			}
		}
		return ret;
	}
	
}
