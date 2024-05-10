package  ma.zs.emailling.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.emailling.bean.core.commun.EtatEmail;
import ma.zs.emailling.dao.criteria.core.commun.EtatEmailCriteria;
import ma.zs.emailling.service.facade.admin.commun.EtatEmailAdminService;
import ma.zs.emailling.ws.converter.commun.EtatEmailConverter;
import ma.zs.emailling.ws.dto.commun.EtatEmailDto;
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
@RequestMapping("/api/admin/etatEmail/")
public class EtatEmailRestAdmin  extends AbstractController<EtatEmail, EtatEmailDto, EtatEmailCriteria, EtatEmailAdminService, EtatEmailConverter> {



    @Operation(summary = "upload one etatEmail")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple etatEmails")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all etatEmails")
    @GetMapping("")
    public ResponseEntity<List<EtatEmailDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all etatEmails")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatEmailDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a etatEmail by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EtatEmailDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new EtatEmail(libelle));
    }

    @Operation(summary = "Saves the specified  etatEmail")
    @PostMapping("")
    public ResponseEntity<EtatEmailDto> save(@RequestBody EtatEmailDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  etatEmail")
    @PutMapping("")
    public ResponseEntity<EtatEmailDto> update(@RequestBody EtatEmailDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of etatEmail")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatEmailDto>> delete(@RequestBody List<EtatEmailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified etatEmail")
    @DeleteMapping("")
    public ResponseEntity<EtatEmailDto> delete(@RequestBody EtatEmailDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified etatEmail")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple etatEmails by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a etatEmail and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatEmailDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds etatEmails by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatEmailDto>> findByCriteria(@RequestBody EtatEmailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated etatEmails by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatEmailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports etatEmails by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatEmailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets etatEmail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatEmailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EtatEmailRestAdmin (EtatEmailAdminService service, EtatEmailConverter converter) {
        super(service, converter);
    }




}
