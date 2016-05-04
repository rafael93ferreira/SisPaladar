package br.com.entidades;

public class Usuario {

	private String login;
	private String senha;
	private String nome;
	private String email;
	private String telefone;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	private Integer idContato;
	
	
	public Integer getIdContato() {
		return idContato;
	}
	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString(){
		return "Usuario [idContato= "+idContato+",login= "+login+",senha= "+senha+",nome= "+nome+"email= "+email+
				",telefone= "+telefone+"]";
	}
}
