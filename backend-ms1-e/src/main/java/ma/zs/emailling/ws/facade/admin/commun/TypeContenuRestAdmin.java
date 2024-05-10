package  ma.zs.emailling.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.emailling.bean.core.commun.TypeContenu;
import ma.zs.emailling.dao.criteria.core.commun.TypeContenuCriteria;
import ma.zs.emailling.service.facade.admin.commun.TypeContenuAdminService;
import ma.zs.emailling.ws.converter.commun.TypeContenuConverter;
import ma.zs.emailling.ws.dto.commun.TypeContenuDto;
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
@RequestMapping("/api/admin/typeContenu/")
public class TypeContenuRestAdmin  extends AbstractController<TypeContenu, TypeContenuDto, TypeContenuCriteria, TypeContenuAdminService, TypeContenuConverter> {



    @Operation(summary = "upload one typeContenu")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple typeContenus")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all typeContenus")
    @GetMapping("")
    public ResponseEntity<List<TypeContenuDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all typeContenus")
    @GetMapping("optimized")
    public ResponseEntity<List<TypeContenuDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a typeContenu by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<TypeContenuDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new TypeContenu(libelle));
    }

    @Operation(summary = "Saves the specified  typeContenu")
    @PostMapping("")
    public ResponseEntity<TypeContenuDto> save(@RequestBody TypeContenuDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  typeContenu")
    @PutMapping("")
    public ResponseEntity<TypeContenuDto> update(@RequestBody TypeContenuDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of typeContenu")
    @PostMapping("multiple")
    public ResponseEntity<List<TypeContenuDto>> delete(@RequestBody List<TypeContenuDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified typeContenu")
    @DeleteMapping("")
    public ResponseEntity<TypeContenuDto> delete(@RequestBody TypeContenuDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified typeContenu")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple typeContenus by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a typeContenu and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeContenuDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds typeContenus by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypeContenuDto>> findByCriteria(@RequestBody TypeContenuCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated typeContenus by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypeContenuCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports typeContenus by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TypeContenuCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets typeContenu data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypeContenuCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TypeContenuRestAdmin (TypeContenuAdminService service, TypeContenuConverter converter) {
        super(service, converter);
    }




}
