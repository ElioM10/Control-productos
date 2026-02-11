package lpj.controlproductos.services;

import lombok.extern.slf4j.Slf4j;
import lpj.controlproductos.model.DetallesUsuario;
import lpj.controlproductos.model.Rol;
import lpj.controlproductos.model.Usuario;
import lpj.controlproductos.repositories.UsuarioRepository;
import lpj.controlproductos.services.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
@Slf4j
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    @Override
    @Transactional
    public Usuario saveUsuario(Usuario usuario) {
        log.info("contraseña sin codificar: "+usuario.getPassword());
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        log.info("contraseña codificada: "+usuario.getPassword());

        DetallesUsuario detallesUsuario = new DetallesUsuario();
        detallesUsuario.setUsuario(usuario);

        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public void deleteUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }

        Set<GrantedAuthority> roles = new HashSet<>();

        for (DetallesUsuario detalles : usuario.getDetalles()) {
            Rol rol = detalles.getRol();
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }

        return new User(usuario.getUsername()
                , usuario.getPassword(),
                roles);
    }

    public boolean existePorUsername(String username){
        return usuarioRepository.existsByUsername(username);
    }

}
