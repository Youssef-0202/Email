package  ma.zs.emailling.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.emailling.bean.core.commun.Utilisateur;
import ma.zs.emailling.dao.criteria.core.commun.UtilisateurCriteria;
import ma.zs.emailling.service.facade.admin.commun.UtilisateurAdminService;
import ma.zs.emailling.ws.converter.commun.UtilisateurConverter;
import ma.zs.emailling.ws.dto.commun.UtilisateurDto;
import ma.zs.emailling.zynerator.controller.AbstractController;
import ma.zs.emailling.zynerator.dto.AuditEntityDto;
import ma.zs.emailling.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.emailling.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.emailling.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/utilisateur/")
public class UtilisateurRestAdmin  extends AbstractController<Utilisateur, UtilisateurDto, UtilisateurCriteria, UtilisateurAdminService, UtilisateurConverter> {



    @Operation(summary = "upload one utilisateur")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple utilisateurs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all utilisateurs")
    @GetMapping("")
    public ResponseEntity<List<UtilisateurDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all utilisateurs")
    @GetMapping("optimized")
    public ResponseEntity<List<UtilisateurDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a utilisateur by email")
    @GetMapping("email/{email}")
    public ResponseEntity<UtilisateurDto> findByEmail(@PathVariable String email) {
        return super.findByReferenceEntity(new Utilisateur(email));
    }

    @Operation(summary = "Saves the specified  utilisateur")
    @PostMapping("")
    public Utilisateur save(@RequestBody Utilisateur utilisateur) throws Exception {
        return service.save(utilisateur);
    }

    @Operation(summary = "Updates the specified  utilisateur")
    @PutMapping("")
    public ResponseEntity<UtilisateurDto> update(@RequestBody UtilisateurDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of utilisateur")
    @PostMapping("multiple")
    public ResponseEntity<List<UtilisateurDto>> delete(@RequestBody List<UtilisateurDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified utilisateur")
    @DeleteMapping("")
    public ResponseEntity<UtilisateurDto> delete(@RequestBody UtilisateurDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified utilisateur")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple utilisateurs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a utilisateur and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<UtilisateurDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds utilisateurs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<UtilisateurDto>> findByCriteria(@RequestBody UtilisateurCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated utilisateurs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody UtilisateurCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports utilisateurs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody UtilisateurCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets utilisateur data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody UtilisateurCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public UtilisateurRestAdmin (UtilisateurAdminService service, UtilisateurConverter converter) {
        super(service, converter);
    }




}
